package biydaalt.model;


//Барааны модел класс
public class ProductModel {
    public String ner,une;
    public int id,count;
    //    Байгуулагч фунцк
    public ProductModel(int id, String ner, String une, int count) {
        this.id=id;
        this.count=count;
        this.ner=ner;
        this.une=une;
    };
    //    Барааны ID-г авах үйлдэл
    public int getId(){
        return id;
    }
    //    Барааны нэрийг авах үйлдэл
    public String getName(){
        return ner;
    }
    //    Барааны үнийг авах үйлдэл
    public String getUne(){
        return une;
    }
    //    Барааны тоог авах үйлдэл
    public int getCount(){
        return count;
    }
}
