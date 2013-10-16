/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital.app.config;

import org.springframework.context.ApplicationContext;

/**
 *
 * @author Hospital Management
 */

public class GetContext 
{
    private static ApplicationContext ctx;

    public static void setApplicationContext(ApplicationContext applicationContext) 
    {
        ctx = applicationContext;
    }
    
    public static ApplicationContext getApplicationContext() 
    {
        return ctx;
    }
}
