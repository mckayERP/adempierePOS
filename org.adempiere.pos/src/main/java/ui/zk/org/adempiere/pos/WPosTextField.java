/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * Copyright (C) 2003-2014 E.R.P. Consultores y Asociados, C.A.               *
 * All Rights Reserved.                                                       *
 * Contributor(s): Raul Muñoz www.erpcya.com					              *
 *****************************************************************************/

package org.adempiere.pos;

import java.text.Format;

import org.adempiere.webui.apps.AEnv;
import org.adempiere.webui.component.Textbox;
import org.zkoss.zhtml.Table;
import org.zkoss.zhtml.Td;
import org.zkoss.zhtml.Tr;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;

/**
 * 
 * @author Raul Muñoz 20/03/2015 
 */
public class WPosTextField extends Div {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2453719110038264481L;
	WPOS pos = null;
	int keyLayoutId = 0;
	
	private Textbox			f_HiddenField;
	private Textbox			f_TextField;
	private	String 			m_FontSize;
	private	String			m_FontStyle;
	public  static final String PRIMARY = "P";
	public  static final String SECONDARY = "S";
	private Table grid;
	/**	Key Board				*/
	public WPosTextField( WPOS pos, final int posKeyLayout_ID, Format format ) {
		super();
		
		keyLayoutId = posKeyLayout_ID;
		this.pos = pos;
		
	}
	
	public int getKeyLayoutId() {
		return keyLayoutId;
	}

	public WPosTextField( WPOS pos, final int posKeyLayout_ID) {
		super();
		
		keyLayoutId = posKeyLayout_ID;
		this.pos = pos;
		f_HiddenField = new Textbox();
		f_HiddenField.setStyle("position:relative; left:-100%; margin-top:-20px; width:100%; height:100%; opacity:0.0");
		f_TextField = new Textbox();
		f_TextField.setHeight("23px");
		f_TextField.setStyle("Font-size:medium; font-weight:bold");
		
		grid = new Table();
		appendChild(grid);
		this.setWidth("100%");
		grid.setStyle("border: none; padding: 0px; margin: 0px;");
		grid.setDynamicProperty("width", "100%");
		grid.setDynamicProperty("border", "0");
		grid.setDynamicProperty("cellpadding", "0");
		grid.setDynamicProperty("cellspacing", "0");

		Tr tr = new Tr();
		grid.appendChild(tr);
		tr.setStyle("width: 100%; border: none; padding: 0px; margin: 0px; white-space:nowrap; ");

		Td td = new Td();
		tr.appendChild(td);
		td.setStyle("border: none; padding: 0px; margin: 0px;");
		
		td.appendChild(f_TextField);
		td.appendChild(f_HiddenField);
		
		String style = AEnv.isFirefox2() ? "display: inline"
				: "display: inline-block";
		style = style
				+ ";border: none; padding: 0px; margin: 0px; background-color: transparent;";
		this.setStyle(style);
	}
	
	/**
	 * Get Font Size 
	 * @return String
	 */
	public String getFontSize() {
		return m_FontSize;
	}
	
	/**
	 *  Set Font Size
	 * @param p_FontSize
	 * @return void
	 */
	public void setFontSize(String p_FontSize) {
		this.m_FontSize = p_FontSize;
	}
	
	/**
	 * Get Font Style 
	 * @return String
	 */
	public String getFontStyle() {
		return m_FontStyle;
	}

	/**
	 * Set Font Style
	 * @param p_FontStyle
	 * @return void
	 */
	public void setFontStyle(String p_FontStyle) {
		this.m_FontStyle = p_FontStyle;
	}
	
	/** 
	 * Set Width
	 * @param Width
	 * @return void
	 */
	public void setWidth(String width){
		f_TextField.setWidth(width);
		grid.setDynamicProperty("width", width);
	}
	
	/**
	 * Set Height
	 * @param Height
	 * @return void
	 */
	public void setHeight(String height){
		f_TextField.setHeight(height);
		
	}
	
	/**
	 * Set Style
	 * @param style
	 * @return void
	 */
	public void setStyle(String style) {
		f_TextField.setStyle(style);
	}
	
	@Override
	public boolean addEventListener(String Event, EventListener listener)
	{
		addEventListener(listener);
	    return true;
	}
	/**
	 * Add Event Listener
	 * @param listener
	 * @return void
	 */
	public void addEventListener(EventListener listener)
	{

		f_TextField.addEventListener(Events.ON_FOCUS, listener);
		f_HiddenField.addEventListener(Events.ON_FOCUS, listener);
	     
	}
	
	/**
	 * Set Value
	 * @param value
	 * @return void
	 */
	public void setValue(String value) {
		f_TextField.setValue(value);
	}

	/**
	 * Get Value
	 * @return
	 * @return String
	 */
	public String getValue() {
		return f_TextField.getValue();
	}
	
	/**
	 * Set Text
	 * @param value
	 * @return void
	 */
	public void setText(String value) {
		if(value != null)
			f_TextField.setValue(value);
		else
			f_TextField.setValue("");
	}
	
	/**
	 * Get Text
	 * @return
	 * @return String
	 */
	public String getText() {
			return f_TextField.getValue();
	}
	
	/**
	 * Set Read Only
	 * @param readOnly
	 * @return void
	 */
	public void setReadonly(Boolean readOnly) {
		f_TextField.setReadonly(readOnly);
		f_HiddenField.setReadonly(readOnly);
	}
	
	/**
	 * Get Component
	 * @param comp
	 * @return
	 * @return Textbox
	 */
	public Textbox getComponent(String comp) {
		if(comp.equals(PRIMARY)) {
			return f_TextField;
		} else if(comp.equals(SECONDARY)){
			return f_HiddenField;
		}
		return null;
	}
	
	/**
	 * Set focus
	 * @param focus
	 * @return void
	 */
	@Override
	public void setFocus(boolean focus){
		f_TextField.setFocus(focus);
	}
			
}
