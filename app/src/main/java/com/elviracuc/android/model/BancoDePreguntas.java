package com.elviracuc.android.model;

import java.util.ArrayList;
import java.util.List;

public class BancoDePreguntas {
    private List<Pregunta> mBanco;
    private int mPosicionActual;

    public BancoDePreguntas(){
        mBanco = new ArrayList<>();
        mPosicionActual = -1;
    }
    public void add(Pregunta pregunta){
        mBanco.add(pregunta);
        if (size() == 1) {
            mPosicionActual = 0;
        }
    }
    public int size(){
        return mBanco.size();
    }
    public boolean isEmpty(){
        return mBanco.isEmpty();
    }
    public Pregunta get(int posicion){
        return mBanco.get(posicion);
    }
    public Pregunta next(){
        if (isEmpty()) {
            return null;
        }
        else {

            mPosicionActual++;

            if(mPosicionActual == size()){
                mPosicionActual = 0;
            }
        }
        return mBanco.get(mPosicionActual);
    }
    public Pregunta previous(){
        if (isEmpty()) {
            return null;
        }
        else {
            if (mPosicionActual == 0) {
                mPosicionActual = size() - 1;
            }
            else {
                mPosicionActual--;
            }
            return mBanco.get(mPosicionActual);
        }
    }
}
