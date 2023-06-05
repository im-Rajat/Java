package corejava;

//class var { // error
    // 'var' is a restricted identifier and cannot be used for type declarations
//}
class TempClass {

}
public class VarKeyword {
    // var v = 10; // error
    public static void main(String[] args) {
        int a = 5;
        var b = 10;
        String var = "Raj";
        int c;
        //var d;  // error

        int nums[] = new int[10];
        //var nums2[] = new int[10];  // error - 'var' is not allowed as an element type of an array
        var nums3 = new int[10];

        var obj = new TempClass();  // will work
    }
}
