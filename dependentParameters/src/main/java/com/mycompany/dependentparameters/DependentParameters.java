/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.dependentparameters;

import hudson.model.ParameterDefinition;
import hudson.model.ParameterValue;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

/**
 *
 * @author vvillegas
 */
public class DependentParameters extends ParameterDefinition{

    public String primaryParameterName;
    public String primaryParameterValue;
    public String secondaryParameterName;
    public String secondaryParameterValue;
    
    @DataBoundConstructor
    public DependentParameters(String primaryParameterName,
            String primaryParameterValue,
            String secondaryParameterName,
            String secondaryParameterValue) {
        super(primaryParameterName, primaryParameterValue);
        this.primaryParameterName = primaryParameterName;
        this.primaryParameterValue = primaryParameterValue;
        this.secondaryParameterName = secondaryParameterName;
        this.secondaryParameterValue = secondaryParameterValue;
    }
    
    @Override
    public ParameterValue createValue(StaplerRequest sr, JSONObject jsono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ParameterValue createValue(StaplerRequest request) {
        String value[] = request.getParameterValues(getName());
        if (value == null) {
            return getDefaultParameterValue();
        }
        return null;
    }
    
}
