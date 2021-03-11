package sample;

import javafx.beans.property.SimpleStringProperty;

public class user {
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty quantity;

    public user (String fid,String fname,String fquantity){
        this.id= new SimpleStringProperty(fid);
        this.name= new SimpleStringProperty(fname);
        this.quantity= new SimpleStringProperty(fquantity);
    }

    public String getId(){
        return id.get();
    }

    public String getName(){
        return name.get();
    }

    public String getQuantity(){
        return quantity.get();
    }

    public void setId(String fid){
        id.set(fid);
    }

    public void setName(String fname){
        name.set(fname);
    }

    public void setQuantity(String fquantity){
        quantity.set(fquantity);
    }

}
