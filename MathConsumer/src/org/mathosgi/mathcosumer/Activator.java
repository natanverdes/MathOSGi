package org.mathosgi.mathcosumer;

import org.mathosgi.mathservice.MathService;
import org.mathosgi.utils.MathUtils;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
        System.out.println("MathConsumer Starting...");
 
        System.out.println("5-3 = " + MathUtils.minus(5, 3));
 
        //
        ServiceReference<?> serviceReference = context
                .getServiceReference(MathService.class);
        MathService service = (MathService) context
                .getService(serviceReference);
 
        System.out.println("5+3 = " + service.sum(5, 3));
 
        System.out.println("MathConsumer Started");
    }
 
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
        System.out.println("MathConsumer Stopped");
    }

}
