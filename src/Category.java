public enum Category {
    Book(true),
    Food(true),
    Medical(true),
    Other(false);

    private boolean isTaxExempted;
    Category(boolean isTaxExempted) {
        this.isTaxExempted = isTaxExempted;
    }

    public boolean isTaxExempted() {
        return isTaxExempted;
    }
}
