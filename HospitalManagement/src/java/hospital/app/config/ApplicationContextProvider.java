/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.app.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author Hospital Management
 */

public class ApplicationContextProvider implements ApplicationContextAware
{
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException 
    {
        GetContext.setApplicationContext(ctx);
    }
}