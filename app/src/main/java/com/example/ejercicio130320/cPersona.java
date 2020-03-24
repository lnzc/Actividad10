package com.example.ejercicio130320;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;


public class cPersona implements Parcelable{

    private String correo;
    private String edad;
    private String nombre;
    private String telefono;

    private ArrayList<cPersona> persona;

    public cPersona(String correo, String edad, String nombre, String telefono){
        this.correo= correo;
        this.edad= edad;
        this.nombre=nombre;
        this.telefono=telefono;
    }
    public cPersona(){
        this.correo="";
        this.telefono="";
        this.nombre="";
        this.edad="";
    }
    public String getMail() {
        return correo;
    }
    public void setMail(String mail) {
        this.correo = correo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getTelefono() {
        return edad;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    protected cPersona(Parcel in) {
        correo = in.readString();
        edad = in.readString();
        nombre = in.readString();
        telefono = in.readString();
        if(in.readByte() == 0x01){
            persona=new ArrayList<cPersona>();
            in.readList(persona, cPersona.class.getClassLoader());
        }else{
            persona=null;
        }
    }

    public static final Creator<cPersona> CREATOR = new Creator<cPersona>() {
        @Override
        public cPersona createFromParcel(Parcel in) {
            return new cPersona(in);
        }

        @Override
        public cPersona[] newArray(int size) {
            return new cPersona[size];
        }
    };

    public String getDatos(){
        return (correo+" "+ edad+" "+nombre+" "+telefono);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(correo);
        dest.writeString(edad);
        dest.writeString(nombre);
        dest.writeString(telefono);
        if(persona==null){
            dest.writeByte((byte) (0x00));
        }else{
            dest.writeByte((byte) (0x01));
            dest.writeList(persona);
        }
    }

}
