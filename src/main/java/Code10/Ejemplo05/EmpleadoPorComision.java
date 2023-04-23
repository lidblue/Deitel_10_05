package Code10.Ejemplo05;

// Fig. 10.7: EmpleadoPorComision.java
// La clase EmpleadoPorComision extiende a Empleado
public class EmpleadoPorComision extends Employee {

    private double grossSales; // gross weekly sales
    private double commissionRate; // commission percentage

    // constructor
    public EmpleadoPorComision(String firstName, String lastName,
            String socialSecurityNumber, double grossSales,
            double commissionRate) {
        super(firstName, lastName, socialSecurityNumber);

        if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate 
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");
        }

        if (grossSales < 0.0) { // validate
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }

        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    // establece el monto de ventas brutas
    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0) { // validate
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }

        this.grossSales = grossSales;
    }

    // devuelve el monto de ventas brutas
    public double getGrossSales() {
        return grossSales;
    }

    // establece la tarifa por comision
    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");
        }

        this.commissionRate = commissionRate;
    }

    // devuelve la tarifa por comision
    public double obtenerTarifaComision() {
        return commissionRate;
    }

    // calcula los ingresos; sobrescribe el método abstracto ingresos en Empleado
    @Override
    public double earnings() {
        return obtenerTarifaComision() * getGrossSales();
    }

    // devuelve representación String de un objeto EmpleadoPorComision
    @Override
    public String toString() {
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",
                "commission employee", super.toString(),
                "gross sales", getGrossSales(),
                "commission rate", obtenerTarifaComision());
    }
}
