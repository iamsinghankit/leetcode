package competitive.singhankit.leetcode.easy.firstsession;

import java.util.stream.Stream;

/**
 * @author _singhankit
 */
public class TailRecursion {
    public static void main(String[] args) {
//        System.out.println(Factorial.factorialTailRec(1, 20).invoke());
    }
}

class Factorial {
    public static TailCall factorialTailRec(final int factorial, final int number) {
        if (number == 1)
            return TailCalls.done(factorial);
        else
            return TailCalls.call(() -> factorialTailRec(factorial * number, number - 1));
    }

    @FunctionalInterface
    public interface TailCall<T> {
        TailCall apply();

        default boolean isComplete() {
            return false;
        }

        default T result() {
            throw new Error("not implemented");
        }

//        default T invoke() {
//            return Stream.iterate(this, TailCall::apply)
//                         .filter(TailCall::isComplete)
//                         .findFirst()
//                         .get()
//                         .result();
//        }
    }

    static class TailCalls {
        public static TailCall call(final TailCall nextCall) {
            return nextCall;
        }

        public static <T> TailCall done(final T value) {
            return new TailCall() {
                @Override
                public boolean isComplete() {
                    return true;
                }

                @Override
                public T result() {
                    return value;
                }

                @Override
                public TailCall apply() {
                    throw new Error("not implemented");
                }
            };
        }
    }
}

