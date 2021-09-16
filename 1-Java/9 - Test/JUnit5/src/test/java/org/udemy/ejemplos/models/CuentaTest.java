package org.udemy.ejemplos.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.udemy.ejemplos.exception.DineroInsuficienteException;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CuentaTest {

    Cuenta cuenta;

    @BeforeEach
    void initMetodoTest() {
        System.out.println("Iniciando el método.");
        cuenta = new Cuenta("Lucas", new BigDecimal("1000.12345"));
        System.out.println("Saldo de la cuenta: $" + cuenta.getSaldo().doubleValue());
    }

    @AfterEach
    void tearDown(){
        System.out.println("Finalizando el método de prueba.");
        System.out.println("Saldo de la cuenta: $" + cuenta.getSaldo().doubleValue());
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("Inicializando el test");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Finalizando el test");
    }

    @Test
    void testNombreCuenta() {
        assertEquals("Lucas", cuenta.getPersona());
    }

    @Test
    void testSaldoCuenta() {
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
    }

    @Test
    void testReferenciaCuenta() {
        var cuenta1 = new Cuenta("Lucas", new BigDecimal("1000.12345"));
        var cuenta2 = new Cuenta("Lucas", new BigDecimal("1000.12345"));

        assertEquals(cuenta1, cuenta2);
    }

    @Test
    void testDebitoCuenta() {
        cuenta.debito(new BigDecimal("100"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta() {
        cuenta.credito(new BigDecimal("100"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testDineroInsuficienteException() {
        var exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal("100000"));
        });
        assertEquals("Dinero insuficiente", exception.getMessage(), () -> "El dinero es suficiente.");
    }

    @Test
    void transferirDineroCuentas() {
        var cuenta1 = new Cuenta("Lucas", new BigDecimal("2500"));
        var cuenta2 = new Cuenta("Andrés", new BigDecimal("1500.8989"));
        var banco = new Banco();
        banco.setNombre("Banco Supervillano");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
        assertEquals("3000", cuenta1.getSaldo().toPlainString());
    }

    @Test
    void testRelacionesBancoCuenta() {
        var cuenta1 = new Cuenta("Lucas", new BigDecimal("2500"));
        var cuenta2 = new Cuenta("Andrés", new BigDecimal("1500.8989"));

        var banco = new Banco();
        banco.setNombre("Banco Supervillano");
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
        assertEquals("3000", cuenta1.getSaldo().toPlainString());

        assertEquals(2, banco.getCuentas().size());
        assertEquals("Banco Supervillano", cuenta1.getBanco().getNombre());
        assertEquals("Lucas", banco.getCuentas().stream().filter(cuenta -> cuenta.getPersona().equals("Lucas")).findFirst().get().getPersona());
        assertTrue(banco.getCuentas().stream().anyMatch(cuenta -> cuenta.getPersona().equals("Lucas")));
    }

    @Test
    @DisplayName("Se testea relacion de banco con assertAll")
    @Disabled
    void testRelacionesBancoCuentaAll() {
        var cuenta1 = new Cuenta("Lucas", new BigDecimal("2500"));
        var cuenta2 = new Cuenta("Andrés", new BigDecimal("1500.8989"));

        var banco = new Banco();
        banco.setNombre("Banco Supervillano");
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        assertAll(() -> assertEquals("1000.8989", cuenta2.getSaldo().toPlainString()),
                () -> assertEquals("3000", cuenta1.getSaldo().toPlainString()),
                () -> assertEquals(2, banco.getCuentas().size()),
                () -> assertEquals("Banco Supervillano", cuenta1.getBanco().getNombre()),
                () -> assertEquals("Lucas", banco.getCuentas().stream().filter(cuenta -> cuenta.getPersona().equals("Lucas")).findFirst().get().getPersona()),
                () -> assertTrue(banco.getCuentas().stream().anyMatch(cuenta -> cuenta.getPersona().equals("Lucas")))
        );
    }

    @Nested
    @DisplayName("Probando tests de sistema operativo")
    class SistemaOperativoTest{
        @Test
        @EnabledOnOs(OS.WINDOWS)
        void testSoloWindows() {

        }

        @Test
        @EnabledOnOs({OS.LINUX, OS.LINUX})
        void testSoloLinux() {

        }

        @Test
        @DisabledOnOs({OS.WINDOWS})
        void testNoWindows() {

        }
    }

    @Nested
    class JavaVersionTest{
        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void testSoloJDK8() {

        }
    }

    @Nested
    class SystemPropertiesTest{
        @Test
        void imprimirPropiedades() {
            var properties = System.getProperties();
            properties.forEach((k, v) -> System.out.println(k + ": " + v));
        }

        @Test
        void testSaldoCuentaDev() {
            var esDev = "dev".equals(System.getProperty("ENV"));
            assumeTrue(esDev);
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        }
    }

    @Tag("param")
    @Nested
    class PruebasParametrizadas{
        @DisplayName("Probando Cuenta Debito Repetir")
        @RepeatedTest(value = 5, name = " {displayName} -  Repetir numero {currentRepetition} de {totalRepetitions}")
        void testDebitoCuentaRepetir(){
            cuenta.debito(new BigDecimal(100));
            assertAll(() -> assertNotNull(cuenta.getSaldo()),
                    () -> assertEquals(900, cuenta.getSaldo().intValue()),
                    () ->  assertEquals("900.12345", cuenta.getSaldo().toPlainString())
            );
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor: {0}")
        @ValueSource(strings = {"100", "200", "300", "500", "700", "1000"})
//    @ValueSource(doubles = {100, 200, 300, 500, 700, 1000.12345})
        void testDebitoCuentaParametrizadoValue(String monto){
            cuenta.debito(new BigDecimal(monto));
            assertAll(() -> assertNotNull(cuenta.getSaldo()),
                    () -> assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0)
            );
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor: {0}")
        @CsvSource({"1,100", "2,200", "3,300", "4,500", "5,700", "6,1000"})
        void testDebitoCuentaParametrizadoCsv(String indice, String monto){
            System.out.println(String.format("%s -> %s", indice, monto));
            cuenta.debito(new BigDecimal(monto));
            assertAll(() -> assertNotNull(cuenta.getSaldo()),
                    () -> assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0)
            );
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor: {0}")
        @CsvSource({"200,100", "250,200", "301,300", "600,500", "750,700", "1000.123456,1000.12345"})
        void testDebitoCuentaParametrizadoCsv2(String saldo, String monto){
            System.out.println(String.format("%s -> %s", saldo, monto));
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            assertAll(() -> assertNotNull(cuenta.getSaldo()),
                    () -> assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0)
            );
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor: {0}")
        @CsvFileSource(resources = "/data.csv")
        void testDebitoCuentaParametrizadoCsvFile(String monto){
            cuenta.debito(new BigDecimal(monto));
            assertAll(() -> assertNotNull(cuenta.getSaldo()),
                    () -> assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0)
            );
        }
    }

    @Tag("param")
    @ParameterizedTest(name = "numero {index} ejecutando con valor: {0}")
    @MethodSource("montoList")
    void testDebitoCuentaParametrizadoMethodSource(String monto){
        cuenta.debito(new BigDecimal(monto));
        assertAll(() -> assertNotNull(cuenta.getSaldo()),
                () -> assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0)
        );
    }

    static List<String> montoList(){
        return Arrays.asList("100", "200", "300", "500", "700", "1000");
    }

    @Tag("timeout")
    @Nested
    class TImeoutTest{
        @Test
        @Timeout(3)
        void pruebaTimeout() throws InterruptedException {
            TimeUnit.SECONDS.sleep(2);
        }

        @Test
        @Timeout(value = 1500, unit = TimeUnit.MILLISECONDS)
        void pruebaTimeout2() throws InterruptedException {
            TimeUnit.SECONDS.sleep(1);
        }

        @Test
        void pruebaTimeoutAssertions(){
            assertTimeout(Duration.ofSeconds(2), () ->{
                TimeUnit.SECONDS.sleep(1);
            });
        }
    }
}