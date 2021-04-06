package biydaalt.model;

public class productModel {
    public String ner,une;
    public int id,count;

    public productModel(int id, String ner, String une, int count) {
        this.id=id;
        this.count=count;
        this.ner=ner;
        this.une=une;
    };

    public int getId(){
        return id;
    }
    public String getName(){
        return ner;
    }
    public String getUne(){
        return une;
    }
    public int getCount(){
        return count;
    }
}
