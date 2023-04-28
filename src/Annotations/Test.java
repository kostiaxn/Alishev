package Annotations;

public class Test {
    @MethodInfo(author = "Kostia", dateOfCreation = 2023, purpose = "Print Hello World!")
    public void printHelloWorld(){
        System.out.println("Hello world");
    }
}
