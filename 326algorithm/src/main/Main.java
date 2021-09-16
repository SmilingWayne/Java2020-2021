package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/training");
        try {
            Scanner scan = new Scanner(file);
            int hostNum = Integer.parseInt(scan.nextLine());
            double totalMoney = 0;
            Map<String, int[]> allHost = new HashMap<>();
            Host[] hosts = new Host[hostNum];
            for (int i = 0; i < hostNum; i++) {
                String a = scan.nextLine();
                //System.out.println(a);
                String[] temp = a.substring(1, a.length() - 1).split(", ");
                //System.out.println(temp[1]);
                allHost.put(temp[0], new int[]{Integer.parseInt(temp[1]) / 2, Integer.parseInt(temp[2]) / 2,
                        Integer.parseInt(temp[3]), Integer.parseInt(temp[4])});
                hosts[i] = new Host(temp[0], Integer.parseInt(temp[1]) / 2,
                        Integer.parseInt(temp[2]) / 2, Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
            }
            Host[] hostsOnCore = new Host[hostNum];
            Arrays.sort(hosts, new Comparator<Host>() {
                @Override
                public int compare(Host o1, Host o2) {
                    if (o1.cost / o1.core > o2.cost / o2.core) {
                        return 1;
                    }
                    return 0;
                }
            });
            hostsOnCore = hosts;
            Arrays.sort(hosts, new Comparator<Host>() {
                @Override
                public int compare(Host o1, Host o2) {
                    if (o1.cost / o1.memory > o2.cost / o2.memory) {
                        return 1;
                    }
                    return 0;
                }
            });
            Host[] hostsOnMemory = hosts;

            Map<String, int[]> vmMap = new HashMap<>();
            Map<Integer, tempRecord> allVM = new HashMap<>();
            int vmNum = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < vmNum; i++) {
                String a = scan.nextLine();
                String[] temp = a.substring(1, a.length() - 1).split(", ");
                vmMap.put(temp[0], new int[]{Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3])});
            }
            //System.out.println(allHost.length);
        /*
        我们这里还需要一个Hash 专门记录从头到尾每个VM的订单号以及他存在的位置
         */
            Map<Integer, usedHost> use = new HashMap<>();
            int totalDays = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < totalDays; i++) {
                int procedures = Integer.parseInt(scan.nextLine());
                Map<Integer, Integer> todayOrder = new HashMap<>();
                int original = use.size();
                List<Integer> copyList = new ArrayList<>();
                for (int j = 0; j < procedures; j++) {
                /*
                    差一个细节：要按照顺序把每天不同序号的虚拟机都存下来，我们一边拿，一边存
                 */
                    String request = scan.nextLine();
                    request = request.substring(1, request.length() - 1);
                    String[] requestVM = request.split(", ");
                    //这里直接记录下每天按照编号存储的单号
                    if (requestVM[0].equals("add")) {
                        int orderNum = Integer.parseInt(requestVM[2]);
                        copyList.add(orderNum);
                        todayOrder.put(j, orderNum);
                        String target = requestVM[1];
                        int targetNum = Integer.parseInt(requestVM[2]);
                        int[] targetVM = vmMap.get(target);
                        if (targetVM[2] == 1) {
                            int location = addDoubleSideVirtualMachine(targetVM, use);
                            if (location != -1) {
                                use.get(location).containVm.add(targetNum);
                                use.get(location).leftRestCore -= targetVM[0] / 2;
                                use.get(location).rightRestCore -= targetVM[0] / 2;
                                use.get(location).leftRestMemory -= targetVM[1] / 2;
                                use.get(location).rightRestMemory -= targetVM[1] / 2;
                                allVM.put(orderNum, new tempRecord(location, "AB"));
                            } else {
                                String addedServer = "";
                                if (targetVM[0] > targetVM[1]) {
                                    // 这里做假设：如果目标加入的内容的Core > memory 采用一开始性价比较高的Core排序方式
                                    addedServer = chooseBestServer(targetVM, hostsOnCore);
                                } else {
                                    addedServer = chooseBestServer(targetVM, hostsOnMemory);
                                }
                                int[] detailed = allHost.get(addedServer);
                                usedHost appendix = new usedHost(addedServer, detailed[0] - targetVM[0] / 2,
                                        detailed[0] - targetVM[0] / 2,
                                        detailed[1] - targetVM[1] / 2, detailed[1] - targetVM[1] / 2);
                                allVM.put(orderNum, new tempRecord(use.size(), "AB"));
                                use.put(use.size(), appendix);
                            }
                        } else {
                            int[] singleTemp = addSingleSideVirtualMachine(targetVM, use);
                            String addedTemp = "";
                            if (singleTemp[0] == -1 && singleTemp[1] == -1) {
                                if (targetVM[0] >= targetVM[1]) {
                                    addedTemp = chooseBestServer(targetVM, hostsOnCore);
                                } else {
                                    addedTemp = chooseBestServer(targetVM, hostsOnMemory);
                                }
                                int[] detailed = allHost.get(addedTemp);
                                usedHost appendix = new usedHost(addedTemp, detailed[0] - targetVM[0], detailed[0],
                                        detailed[1] - targetVM[1], detailed[i] - targetVM[1]);
                                allVM.put(orderNum, new tempRecord(use.size(), "A"));
                                use.put(use.size(), appendix);
                            } else {
                                int destination = singleTemp[0];
                                if (singleTemp[1] == 1) {
                                    allVM.put(orderNum, new tempRecord(destination, "A"));
                                    use.get(destination).leftRestCore -= targetVM[0];
                                    use.get(destination).leftRestMemory -= targetVM[1];
                                    use.get(destination).containVm.add(Integer.parseInt(target));
                                    use.get(destination).direction = 1;
                                } else if (singleTemp[1] == 2) {
                                    allVM.put(orderNum, new tempRecord(destination, "B"));
                                    use.get(destination).rightRestCore -= targetVM[0];
                                    use.get(destination).rightRestMemory -= targetVM[1];
                                    use.get(destination).containVm.add(Integer.parseInt(target));
                                    use.get(destination).direction = 2;
                                }
                            }
                        }
                    } else {
                        for (int k = 0; k < use.size(); k++) {
                            int deleteNum = Integer.parseInt(requestVM[1]);
                            if (use.get(k).containVm.contains(deleteNum)) {
                                if (vmMap.get(allVM.get(deleteNum))[2] == 1) {
                                    int halfMemory = vmMap.get(allVM.get(deleteNum))[1] / 2;
                                    int halfCore = vmMap.get(allVM.get(deleteNum))[0] / 2;
                                    use.get(k).rightRestMemory += halfMemory;
                                    use.get(k).leftRestMemory += halfMemory;
                                    use.get(k).rightRestCore += halfCore;
                                    use.get(k).leftRestCore += halfCore;
                                } else {
                                    if (use.get(k).direction == 1) {
                                        use.get(k).leftRestCore += vmMap.get(allVM.get(deleteNum))[0];
                                        use.get(k).leftRestMemory += vmMap.get(allVM.get(deleteNum))[1];
                                    } else if (use.get(k).direction == 2) {
                                        use.get(k).rightRestCore += vmMap.get(allVM.get(deleteNum))[0];
                                        use.get(k).rightRestMemory += vmMap.get(allVM.get(deleteNum))[1];
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
                int feedBack = use.size() - original;
                purchase(feedBack);
                for (int l = original; l < use.size(); l++) {
                    System.out.println("(" + use.get(l).hostName + ", " + "1)");
                }
                immigration();
                for (int l = 0; l < copyList.size(); l++) {
                    tempRecord tp = allVM.get(copyList.get(l));
                    if (tp.location.equals("AB")) {
                        System.out.println("(" + tp.number + ")");
                    } else if (tp.location.equals("A")) {
                        System.out.println("(" + tp.number + ", " + "A)");
                    } else if (tp.location.equals("B")) {
                        System.out.println("(" + tp.number + ", " + "B)");
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("文件读取失败");
        }

    }
    public static String chooseBestServer(int[] targetVM, Host[] hostsOnCore){
        int n = hostsOnCore.length;
        if(targetVM[2] == 1) {
            for (int i = 0; i < n; i++) {
                if (targetVM[0] / 2 <= hostsOnCore[i].core && targetVM[1] / 2 <= hostsOnCore[i].memory){
                    return hostsOnCore[i].hostName;
                }
            }
        }
        else{
            for(int i = 0 ; i < n ; i ++ ){
                if(hostsOnCore[i].core >= targetVM[0] && hostsOnCore[i].memory >= targetVM[1]){
                    return hostsOnCore[i].hostName;
                }
            }
        }
        return "";
    }
    public static int addDoubleSideVirtualMachine(int[] targetVM, Map<Integer, usedHost> use){
        for(int i = 0 ; i < use.size(); i ++ ){
            if(use.get(i).leftRestCore >= targetVM[0] / 2 && use.get(i).rightRestCore >= targetVM[0] / 2){
                if(use.get(i).leftRestMemory >= targetVM[1] / 2 && use.get(i).rightRestMemory >= targetVM[1] / 2){
                    return i;
                }
            }
        }
        return -1;
    }
    public static void purchase(int x){
        System.out.println("(purchase, " + x + ")");
    }
    public static void immigration(){
        System.out.println("(migration ,0)");
    }
    public static int[] addSingleSideVirtualMachine(int[] targetVM, Map<Integer, usedHost> use ){
        for(int i = 0 ; i < use.size(); i ++ ){
            if(use.get(i).leftRestCore >= targetVM[0] && use.get(i).leftRestMemory >= targetVM[1]){
                return new int[]{i, 1};
            }
            else if(use.get(i).rightRestCore >= targetVM[0] && use.get(i).leftRestMemory >= targetVM[1]){
                return new int[]{i, 2};
            }
        }
        return new int[]{-1, -1};
    }
}
class tempRecord{
    public int number;
    public String location;
    public tempRecord(int number, String location){
        this.number = number;
        this.location = location;
    }
}
class usedHost{
    public Set<Integer> containVm = new HashSet<>();
    public String hostName;
    //public int pos;
    public int leftRestCore ;
    public int rightRestCore ;
    public int leftRestMemory ;
    public int rightRestMemory ;
    public int direction = 0 ;
    /*
    这里的direction记录：如果是单节点，这个虚拟机被放在了什么位置, 如果是双节点，direction 自动被赋予0 在双节点调整过程中不会收到影响

     */
    public usedHost(String hostName, int leftRestCore,
                    int rightRestCore, int leftRestMemory, int rightRestMemory){
        this.hostName = hostName;
        this.leftRestCore = leftRestCore;
        this.rightRestCore = rightRestCore;
        this.leftRestMemory = leftRestMemory;
        this.rightRestMemory = rightRestMemory;
    }
}
class Host{
    public String hostName;
    public int core ;
    public int memory;
    public int cost;
    public int dailyCost;
    public Host(String a, int b, int c , int d , int e){
        this.hostName = a;
        this.core = b;
        this.memory = c;
        this.cost = d;
        this.dailyCost = e;
    }
}