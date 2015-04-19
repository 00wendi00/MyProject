/*
 * Copyright (c) 2005-2008 Obeo
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 */

package fr.obeo.acceleo.gen.template.scripts.imports.services;

import fr.obeo.acceleo.gen.template.scripts.IScript;
import fr.obeo.acceleo.gen.template.scripts.SpecificScript;
import fr.obeo.acceleo.gen.template.scripts.imports.EvalJavaService;

/**
 * Factory that imports the system services for the given script.
 * 
 * @author www.obeo.fr
 * 
 */
public class SystemServicesFactory {

	/**
	 * Adds system imports to the given script.
	 * 
	 * @param script
	 *            is the script
	 * @param isRoot
	 *            indicates if the script is the root
	 */
	public void addImports(IScript script, boolean isRoot) {
		if (isRoot) {
			script.addImport(new EvalJavaService(new StringServices(), false));
			script.addImport(new EvalJavaService(new EObjectServices(), false));
			script.addImport(new EvalJavaService(new XpathServices(), false));
			script.addImport(new EvalJavaService(new ResourceServices(), false));
			script.addImport(new EvalJavaService(new ContextServices(), false));
		}
		script.addImport(new EvalJavaService(new ENodeServices(script), true));
		script.addImport(new EvalJavaService(new RequestServices(script), true));
		if (script instanceof SpecificScript) {
			script.addImport(new EvalJavaService(new PropertiesServices((SpecificScript) script), true));
		}
	}

}