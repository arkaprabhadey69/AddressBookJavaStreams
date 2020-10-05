package com.pattersn;


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AddressBookMain {
    public ArrayList<Contact> persons;
    public HashMap<String, ArrayList<Contact>> StatePersonMap;
    public HashMap<String, ArrayList<Contact>> CityPersonMap;


    Scanner s= new Scanner(System.in);
    Scanner s1= new Scanner(System.in);
    Scanner s2= new Scanner(System.in);
    public AddressBookMain()
    {
        persons = new ArrayList<Contact>();
        StatePersonMap = new HashMap<String,ArrayList<Contact>>();
        CityPersonMap = new HashMap<String,ArrayList<Contact>>();

    }


    public Contact Findname(String name)
    {
        Contact d=new Contact();

        for(int i=0;i<persons.size();i++)
        {
            Contact c= (Contact)persons.get(i);

            if(name.equals(c.firstname))
            {
                d=c;
            }

        }
        System.out.println("\n"+d.firstname+" "+d.lastname+" "+d.address+" "+d.city+" "+d.email+" "+d.zip+"\n");

        return d;

    }
    public void FindName(String city)
    {

//        for(int i=0;i<persons.size();i++)
//        {
//            Contact d= (Contact)persons.get(i);
//
//            if(city.equals(d.city))
//            {
//                System.out.println("\n"+d.firstname+" "+d.lastname+" "+d.address+" "+d.city+" "+d.email+" "+d.zip+"\n");
//            }
//
//        }
        List<Contact> list= persons.stream()
                .filter(p->p.getCity().equals(city))
                .collect(Collectors.toList());
        for(Contact c: list) {
            System.out.println(c.firstname);
        }
    }

    public void FindContactName(String state)
    {

        List<Contact> list= persons.stream().filter(p->p.getState().equals(state)).collect(Collectors.toList());
        for(Contact c: list) {
            System.out.println(c.firstname);
        }
    }
    public void FindCountContactName(String state)
    {

        int list= Math.toIntExact(persons.stream().filter(p -> p.getState().equals(state)).count());
        System.out.println("The number of people living in this state in this address book is: "+list);
    }

    public void SortNames()
    {

        List<Contact> list = persons.stream()
                .sorted(Comparator.comparing(Contact::getName))
                .collect(Collectors.toList());

        for(Contact c: list) {
            System.out.println(c.firstname);
        }

    }
    public void FindDuplicates()
    {
        Set<String> items = new HashSet<>();

        Set<Contact> items1= persons.stream()
                .filter(n->!items.add(n.firstname))
                .collect(Collectors.toSet());
        for(Contact c:items1)
        {
            System.out.println("Duplicate entry is: "+c.firstname);
        }
    }
    public ArrayList<Contact> getList()
    {
        return  persons;
    }



    public void FindPersonByHash(String city)
    {
        ArrayList<Contact> person1 = new ArrayList<Contact>();
        person1 = CityPersonMap.get(city);
        for(int i=0;i<person1.size();i++){
            System.out.println("Firstname "+person1.get(i).firstname+" Lastname "+person1.get(i).lastname+
                    " Address "+person1.get(i).address+" City "+person1.get(i).city+" State "+person1.get(i).state+
                    " Zip "+person1.get(i).zip+" Phone number "+person1.get(i).number+" Email "+person1.get(i).email+"\n");
        }


    }
    public void FindPersonByHashState(String state)
    {
        ArrayList<Contact> person1 = new ArrayList<Contact>();
        person1 = StatePersonMap.get(state);
        for(int i=0;i<person1.size();i++){
            System.out.println("Firstname "+person1.get(i).firstname+" Lastname "+person1.get(i).lastname+
                    " Address "+person1.get(i).address+" City "+person1.get(i).city+" State "+person1.get(i).state+
                    " Zip "+person1.get(i).zip+" Phone number "+person1.get(i).number+" Email "+person1.get(i).email+"\n");
        }

    }
    public void AddName()
    {
        String x,y,z,w,a,b,e;
        String c1;
        System.out.println("Enter your details\n");
        System.out.println("Firstname\n");
        x=s2.nextLine();
//        for(int i=0;i<persons.size();i++)
//        {
//            Contact c= (Contact)persons.get(i);
//
//            if(x.equals(c.firstname))
//            {
//                System.out.println("Error!Name Already taken!");
//                return;
//            }
//
//        }
        System.out.println("Lastname\n");
        y=s2.nextLine();
        System.out.println("Address\n");
        z=s2.nextLine();
        System.out.println("City\n");
        w=s2.nextLine();
        System.out.println("State\n");
        a=s2.nextLine();
        System.out.println("Zip\n");
        b=s2.nextLine();
        System.out.println("Phone No.\n");
        c1=s2.nextLine();
        System.out.println("Email\n");
        e=s2.nextLine();
        Contact c= new Contact(x,y,z,w,a,b,c1,e);
        persons.add(c);
        if(!StatePersonMap.containsKey(a))
            StatePersonMap.put(a, new ArrayList<Contact>());
        StatePersonMap.get(a).add(c);

        if(!CityPersonMap.containsKey(w))
            CityPersonMap.put(w, new ArrayList<Contact>());
        CityPersonMap.get(w).add(c);
        System.out.println("Added succesfully, the contacts are: \n");
        for (int i = 0; i < persons.size(); i++)
        {
            persons.get(i).Display();
        }

    }
    public void edit(String name)
    {

        Contact c=Findname(name);
        System.out.println("Enter which detail to edit\n\n\n1.FirstName\n2.Secondname\n3.Address\n4.City\n5.State\n6.Zip\n7.Phone\n8.Email\n");
        int choice=s.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("Enter new name: \n");
                c.firstname=s1.nextLine();
                for (int i = 0; i < persons.size(); i++)
                {
                    persons.get(i).Display();
                }
                break;
            case 2:
                System.out.println("Enter last name: \n");
                c.lastname=s1.nextLine();
                for (int i = 0; i < persons.size(); i++)
                {
                    persons.get(i).Display();
                }
                break;
            case 3:
                System.out.println("Enter new address:");
                c.address=s1.nextLine();
                for (int i = 0; i < persons.size(); i++)
                {
                    persons.get(i).Display();
                }
                break;
            case 4:
                System.out.println("Enter new city:");
                c.city=s1.nextLine();
                for (int i = 0; i < persons.size(); i++)
                {
                    persons.get(i).Display();
                }
                break;
            case 5:
                System.out.println("Enter new state:");
                c.state=s1.nextLine();
                for (int i = 0; i < persons.size(); i++)
                {
                    persons.get(i).Display();
                }
                break;
            case 6:
                System.out.println("Enter new zip:");
                c.zip=s1.nextLine();
                for (int i = 0; i < persons.size(); i++)
                {
                    persons.get(i).Display();
                }
                break;
            case 7:
                System.out.println("Enter new number:");
                c.number=s1.nextLine();
                for (int i = 0; i < persons.size(); i++)
                {
                    persons.get(i).Display();
                }
                break;
            case 8:
                System.out.println("Enter new email:");
                c.email=s1.nextLine();
                for (int i = 0; i < persons.size(); i++)
                {
                    persons.get(i).Display();
                }
                break;
            default:
                break;


        }


    }

    public void delete(String name)
    {
        for(int i=0;i<persons.size();i++)
        {

            Contact c= (Contact)persons.get(i);
            if(name.equals(c.firstname))
            {
                persons.remove(i);
            }
        }
        for (int i = 0; i < persons.size(); i++) {
            System.out.println("After Deletion");
            persons.get(i).Display();
        }


    }



}
