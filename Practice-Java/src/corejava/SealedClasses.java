package corejava;

sealed class TempA permits TempB, TempC {
}
final class TempB extends TempA {
}
non-sealed class TempC extends TempA {
}
//class TempD extends TempA {
    // error - 'TempD' is not allowed in the sealed hierarchy
//}
sealed class TempE extends Thread implements Cloneable permits TempF, TempG {
}
non-sealed class TempF extends TempE {
}
non-sealed class TempG extends TempE {
}

sealed interface TempX permits TempY {
}
non-sealed interface TempY extends TempX {
}

public class SealedClasses {
    public static void main(String[] args) {

    }
}
