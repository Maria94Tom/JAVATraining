package tostring;
//clone() : clone and returns a copy of the object

public class Member implements Cloneable
{
    //clone() : clone and returns a copy of the object
    private String name;
    private int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("name= "+name).append("\n");
        sb.append("age= "+age);
        return sb.toString();
    }
    @Override
    public Member clone(){
        try{
            return (Member)super.clone();
        }catch(CloneNotSupportedException e){
            return null;
        }

    }

    public static void main(String[] args){
        Member p1 = new Member("John", 30);
        Member p2 = (Member) p1.clone();
        System.out.println(p2);

        //when we call getClass() method it returns a Class object

    }
}
