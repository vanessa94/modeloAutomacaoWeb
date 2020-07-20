package core;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import enums.Types;

public class Elements {
	private Types type;
	private String map;
	private WebElement webElement = null;
	private HashMap<Types, By> byMap = new HashMap<Types, By>();

	public Elements(Types type, String map) {
		this.type = type;
		this.map = map;
		setByMap();
	}
	
	private void setByMap() {
		byMap.put(Types.ID, By.id(map));
		byMap.put(Types.XPATH, By.xpath(map));
		byMap.put(Types.CSS, By.cssSelector(map));
		byMap.put(Types.LINKTEXT, By.linkText(map));
		byMap.put(Types.NAME, By.name(map));
	}
	
	public void setWebElement(WebElement webElement) {
		this.webElement = webElement;
	}
	
	public WebElement getElement() {
		return get(byMap.get(type));
	}
	
	public WebElement get(By type) {
		if(webElement == null) {
			return Driver.getDriver().findElement(type);
		}
			return webElement.findElement(type);
	}
	
	public List<WebElement> getElements() {
		return Driver.getDriver().findElements(byMap.get(type));
	}

	public void sendKeys(CharSequence... value) {
		getElement().sendKeys(value);
	}

	public String getText() {
		return getElement().getText();
	}

	public void click() {
		getElement().click();
	}

	public String getAttribute(String value) {
		return getElement().getAttribute(value);
	}

	public void clear() {
		getElement().clear();
	}

	public boolean isEnabled() {
		return getElement().isEnabled();
	}

	public boolean isDiplayed() {
		return getElement().isDisplayed();
	}
	
	public boolean isSelected() {
		return getElement().isSelected();
	}
	
	public void select(String value) {
		Select select = new Select(getElement());
		select.selectByVisibleText(value);
	}

}
