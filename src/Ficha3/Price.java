package Ficha3;

public class Price {

    enum Code {REGULAR, CHILDRENS, NEW_RELEASE}

    private Code _code;

    public Price(Code _code) {
        this._code = _code;
    }

    public Code get_code() {
        return _code;
    }

    public double getRentalAmount(int duration) {
        double result = 0;

        // determine amounts for each line
        switch (_code)
        {
            case REGULAR:
                result += 2;
                if (duration > 2)
                    result += (duration - 2) * 1.5;
                break;
            case NEW_RELEASE:
                result += duration * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (duration > 3)
                    result += (duration - 3) * 1.5;
                break;
        }
        return result;
    }

    public int getFrequentRentalPoints(int daysRented)
    {
        return ((_code == Code.NEW_RELEASE) && daysRented > 1) ? 2 : 1;
    }

}