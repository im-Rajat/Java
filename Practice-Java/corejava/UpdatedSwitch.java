package corejava;

public class UpdatedSwitch {
    public static void main(String[] args) {

        String day = "Monday";

        switch (day) {
            case "Saturday", "Sunday" -> System.out.println("6am");
            case "Monday" -> System.out.println("8am");
            default -> System.out.println("7am");
        }

        // now switch can return as well
        String result = switch (day) {
            case "Saturday", "Sunday" -> "6am";
            case "Monday" -> "8am";
            default -> "7am";
        };
        System.out.println(result);

        // if instead of arrow, we want to use colon
        // then we need to use a keyword yield
        String result2 = switch (day) {
            case "Saturday", "Sunday" : yield "6am";
            case "Monday" : yield "8am";
            default : yield "7am";
        };
        System.out.println(result2);
    }
}
