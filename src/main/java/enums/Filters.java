package enums;

public enum Filters {
	MARKE ("Marke"),
	PRODUKTART ("Produktart"),
	GESCHENK_FUR ("Geschenk fur"),
	FUR_WEN ("Für Wen");
		 
    private String filter;
    public String getFilterName()
    { 
        return this.filter;
    }
    
    private Filters(String filter)
    { 
        this.filter = filter;
    }

}