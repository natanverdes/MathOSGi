package org.mathosgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.mathosgi.mathservice.impl.MathServiceImpl;
import org.mathosgi.mathservice.MathService;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
        
        System.out.println("Registry Service MathService...");
        
        this.registryMathService();
        
        System.out.println("OSGi MathService Started");
    }
	 
    private void registryMathService() {
        MathService service = new MathServiceImpl();
        context.registerService(MathService.class, service, null);
    }
	 
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
        System.out.println("OSGi MathService Stopped!");
    }

}
