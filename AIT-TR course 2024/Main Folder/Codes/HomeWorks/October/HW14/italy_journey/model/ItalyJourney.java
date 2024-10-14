package HW14.italy_journey.model;
//Задача 2. Семья планирует поехать в отпуск в Италию из Германии и покрыть порядка 3000 км. Имеется информация о 5 автомобилях на жидком топливе (бензин или дизтопливо):
//
//марка автомобиля: Audi, BMW, Opel, VW, Mercedes.
//тип расходуемого топлива: d, b, d, d, b
//стоимость 1 литра топлива: d - 1.6, b - 1.8
//расход на 100 км пути: 6.6, 6.8, 6.9, 6.5, 6.3
//стоимость недельной аренды автомобиля: 45, 49, 45, 39, 49 Какой автомобиль ей следует выбрать, исходя из минимальной стоимости?

//public final double DIESEL_COST = 1.6;
//public final double GASOLINE_COST = 1.8;

import java.util.Objects;

public class ItalyJourney {




    String Brand;
    char fuelType;
    float fuelConsumption;
    int weekRentCost;


    public ItalyJourney(String brand, char fuelType, float fuelConsumption, int weekRentCost) {
        Brand = brand;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.weekRentCost = weekRentCost;
    }


    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public char getFuelType() {
        return fuelType;
    }

    public void setFuelType(char fuelType) {
        this.fuelType = fuelType;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getWeekRentCost() {
        return weekRentCost;
    }

    public void setWeekRentCost(int weekRentCost) {
        this.weekRentCost = weekRentCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItalyJourney that)) return false;
        return fuelType == that.fuelType && Float.compare(fuelConsumption, that.fuelConsumption) == 0 && weekRentCost == that.weekRentCost && Objects.equals(Brand, that.Brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Brand, fuelType, fuelConsumption, weekRentCost);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ItalyJourney{");
        sb.append("Brand='").append(Brand).append('\'');
        sb.append(", fuelType=").append(fuelType);
        sb.append(", fuelConsumption=").append(fuelConsumption);
        sb.append(", weekRentCost=").append(weekRentCost);
        sb.append('}');
        return sb.toString();
    }
}//end class
