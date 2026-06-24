class Solution {
    public double[] convertTemperature(double celsius) {
        double[] res = new double[2];
        double k = celsius + 273.15;
        double f = celsius * 1.80 + 32.00;
        res[0] = Math.round(k * 100000.0) / 100000.0;
        res[1] = Math.round(f * 100000.0) / 100000.0;
        return res;
    }
}