public record Moneda(
        String base_code,
        String target_code,
        double conversion_rate,
        double conversion_result

) {
    @Override
    public String toString() {
        return "Moneda{" +
                "base_code='" + base_code + '\'' +
                ", target_code='" + target_code + '\'' +
                ", conversion_rate=" + conversion_rate +
                ", conversion_result=" + conversion_result +
                '}';
    }
}
