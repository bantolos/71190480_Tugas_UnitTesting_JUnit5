import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {
    static Karyawan karyawan;

    @BeforeAll
    static void init() {
        karyawan = new Karyawan();
//        System.out.println("before all execute");
    }

    @AfterAll
    static void destroy(){
        karyawan = null;
//        System.out.println("after all execute");
    }

    /////////////// EQUIVALENCE CLASS PARTITIONING ///////////////

    private static Stream<Arguments> provideSalary(){
        return Stream.of(
                Arguments.of(0, 3000000),
                Arguments.of(10, 10000000),
                Arguments.of(22, 25000000),
                Arguments.of(40f, 75000000),
                Arguments.of(-1, -1000000),
                Arguments.of(-1, 10000000000000f)
        );
    }

    @ParameterizedTest
    @MethodSource("provideSalary")
    void testEC(float expected, double salary){
        assertEquals(expected, karyawan.getPajak(salary));
    }

    /////////////// BOUNDARY VALUE ANALYSIS ///////////////

    // BVA 1 (vEC1 dan vEC2)
    private static Stream<Arguments> BVA1Parameters(){
        return Stream.of(
                Arguments.of(true, 3999999),
                Arguments.of(true, 4000000),
                Arguments.of(false, 4000001)
        );
    }

    @ParameterizedTest
    @MethodSource("BVA1Parameters")
    void testBVA1Parameters(boolean expected, double salary){
        Assertions.assertNotNull(karyawan);
        Assertions.assertEquals(expected, karyawan.getPajak(salary) == 0);
    }

    // BVA 2 (vEC2 dan vEC3)
    private static Stream<Arguments> BVA2Parameters(){
        return Stream.of(
                Arguments.of(true, 14999999),
                Arguments.of(true, 15000000),
                Arguments.of(false, 15000001)
        );
    }

    @ParameterizedTest
    @MethodSource("BVA2Parameters")
    void testBVA2Parameters(boolean expected, double salary){
        Assertions.assertNotNull(karyawan);
        Assertions.assertEquals(expected, karyawan.getPajak(salary) == 10);
    }

    // BVA 3 (vEC3 dan vEC4)
    private static Stream<Arguments> BVA3Parameters(){
        return Stream.of(
                Arguments.of(true, 39999999),
                Arguments.of(true, 40000000),
                Arguments.of(false, 40000001)
        );
    }

    @ParameterizedTest
    @MethodSource("BVA3Parameters")
    void testBVA3Parameters(boolean expected, double salary){
        Assertions.assertNotNull(karyawan);
        Assertions.assertEquals(expected, karyawan.getPajak(salary) == 22);
    }

    // BVA 4 (vEC4)
//    private static Stream<Arguments> BVA4Parameters(){
//        return Stream.of(
//                Arguments.of(true, 999999999998f),
//                Arguments.of(true, 999999999999f),
//                Arguments.of(false, 1000000000000f)
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("BVA4Parameters")
//    void testBVA4Parameters(boolean expected, double salary){
//        Assertions.assertNotNull(karyawan);
//        Assertions.assertEquals(expected, karyawan.getPajak(salary) == 40f);
//    }
//
//    // BVA 5 (vEC1)
//    private static Stream<Arguments> BVA5Parameters(){
//        return Stream.of(
//                Arguments.of(false, -1),
//                Arguments.of(true, 0),
//                Arguments.of(true, 1)
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("BVA5Parameters")
//    void testBVA5Parameters(boolean expected, double salary){
//        Assertions.assertNotNull(karyawan);
//        Assertions.assertEquals(expected, karyawan.getPajak(salary) == 0);
//    }
}
