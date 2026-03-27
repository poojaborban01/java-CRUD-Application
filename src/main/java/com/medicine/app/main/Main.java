package com.medicine.app.main;

import com.medicine.app.entity.MediEntity;
import com.medicine.app.repository.MediRepo;

public class Main {

    public static void main (String[] args)
    {


            MediEntity medi = new MediEntity();
            medi.setId(1);
            medi.setName("Paracetamol");
            medi.setPrice(50);
            medi.setQuantity(10);

            MediRepo repo = new MediRepo();
            repo.saveMedi(medi);

            System.out.println("Data inserted successfully!");
        }

    }

