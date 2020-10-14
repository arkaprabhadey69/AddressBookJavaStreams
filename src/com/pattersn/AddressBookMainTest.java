package com.pattersn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AddressBookMainTest {

    @Test
    public void given_Contacts_Should_Write_To_A_File(){
        Contact[] contacts={new Contact("Arka","Dey","lmao","kol","wb","700026","8961377960","abc@gmail.com" ),
                new Contact("Mayuri","Dey","lmao","kol","wb","700089","8961388960","abcd@gmail.com" ),
                new Contact("Nayanika","Guha","lmao","kol","wb","700096","8961377900","abcdef@gmail.com" )};
        ArrayList<Contact> arr=new ArrayList<>();
        arr.add(contacts[0]);
        arr.add(contacts[1]);
        arr.add(contacts[2]);
        AddressBookMain adressBook= new AddressBookMain();
        adressBook.writeData(arr);
        long entries=adressBook.countEntries();
        Assert.assertEquals(3,entries);


    }

}