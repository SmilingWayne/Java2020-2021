package JavaClass1;

public class Item {
    private String description;
    private int partNumber;
    public Item(String aDescription,int aPartNumber){
        description = aDescription;
        partNumber = aPartNumber;
    }
    public String getDescription(){
        return description;
    }
    public int getPartNumber(){
        return partNumber;
    }
    public String toStirng(){
        return "[Description="+description+",partNumber="+partNumber+"]";
    }
    public boolean equals(Object otherObject){
        if(this==otherObject)
            return true;
        if(otherObject==null)
            return false;
        if(getClass()!=otherObject.getClass())
            return false;
        Item other = (Item) otherObject;
        return this.description.equals(((Item) otherObject).description) && partNumber
                ==other.partNumber;
    }
    //这一段代码好好看下，注意一个细节就是otherObject要先转化成Item类型//


}
