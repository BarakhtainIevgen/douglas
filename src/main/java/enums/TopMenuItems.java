package enums;

public enum TopMenuItems {	
	PARFUM_SALE ("PARFUM", "SALE"),
    PARFUM_NEU ("PARFUM", "NEU"),
	PARFUM_LIMITIERT ("PARFUM", "LIMITIERT");
		 
    private String parent_menu;
    private String child_menu;

    public String getParentMenuName()
    {
        return this.parent_menu;
    }
    public String getChildMenuName()
    { 
        return this.child_menu;
    } 
    
    private TopMenuItems(String parent_menu, String child_menu)
    { 
        this.parent_menu = parent_menu;
        this.child_menu = child_menu;
    } 
}