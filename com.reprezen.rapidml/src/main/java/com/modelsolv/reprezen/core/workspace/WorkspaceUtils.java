/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.core.workspace;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;

import com.modelsolv.reprezen.core.RapidFileExtensions;

/**
 * Set of utilities around Eclipse or RepreZen workspace. These won't go in the
 * {@link com.modelsolv.reprezen.core.workspace.Workspace} abstraction.
 * 
 * @author jimleroyer
 * @since 2013/05/27
 */
@SuppressWarnings("restriction")
public abstract class WorkspaceUtils {

//    public static final String MODELS_FOLDER_NAME = "models"; //$NON-NLS-1$
//
//    public static File convertToFile(URL url) {
//        File file = null;
//        try {
//            file = new File(safeResolve(url));
//        } catch (URISyntaxException | IOException e1) {
//            throw new RuntimeException(format("The %s URL could not be resolved.", url), e1); //$NON-NLS-1$
//        }
//        return file;
//    }
//
//    /**
//     * Copies a resource located in a bundle, given its name, into a target Eclipse project and a destination resource
//     * name;
//     * 
//     * @param sourceBundleName
//     *            The bundle name where the resource is located.
//     * @param sourceResourceName
//     *            The resource name to copy.
//     * @param targetProject
//     *            The target project where the resource will be copied.
//     * @param targetResourceName
//     *            The new resource name, including the relative path to the target project.
//     * @return Newly created resource, as a IFile.
//     * @throws RepreZenException
//     */
//    public static IResource copyResource(String sourceBundleName, String sourceResourceName, IProject targetProject,
//            String targetResourceName) throws RepreZenException {
//        Bundle sourceBundle = Platform.getBundle(sourceBundleName);
//
//        URL singleResourceURL = sourceBundle.getResource(sourceResourceName);
//        Enumeration<URL> folderUrls = sourceBundle.findEntries(sourceResourceName, "*", true); //$NON-NLS-1$
//
//        List<URL> urls = new ArrayList<>();
//        if (singleResourceURL != null) {
//            urls.add(singleResourceURL);
//        }
//
//        if (folderUrls != null) {
//            Iterators.addAll(urls, Iterators.forEnumeration(folderUrls));
//        }
//
//        long timestamp = sourceBundle.getLastModified();
//
//        for (URL url : urls) {
//            try {
//                String path = url.toURI().getPath();
//                if (!path.endsWith("/")) { // ignore directory //$NON-NLS-1$
//                    IPath relativePath = new Path(path).makeRelativeTo(new Path(sourceResourceName));
//                    IFile targetFile = targetProject.getFile(new Path(targetResourceName).append(relativePath));
//                    if (!targetFile.exists() || targetFile.getLocalTimeStamp() != timestamp) {
//                        createResourceHierarchy(targetFile, new NullProgressMonitor());
//                        if (targetFile.getLocalTimeStamp() != timestamp) {
//                            try (InputStream in = url.openStream()) {
//                                targetFile.setContents(in, true, false, new NullProgressMonitor());
//                                targetFile.setLocalTimeStamp(timestamp);
//                            }
//                        }
//                    }
//                }
//            } catch (IOException | URISyntaxException | CoreException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        return targetProject.getFolder(targetResourceName);
//    }
//
//    /**
//     * Recursively creates a resource, checking if a given parent's resource exist.
//     * 
//     * @param resource
//     *            Resource to create
//     * @param monitor
//     *            Progress monitor
//     * @throws org.eclipse.core.runtime.CoreException
//     */
//    public static void createResourceHierarchy(final IResource resource, IProgressMonitor monitor)
//            throws CoreException {
//        if (resource == null || resource.exists()) {
//            return;
//        }
//        // ZEN-1496 OS X: WorkspaceUtils throws a
//        // "Resource exists with a different case" exception
//        if (!org.eclipse.core.internal.resources.Workspace.caseSensitive
//                && ((Resource) resource).findExistingResourceVariant(resource.getFullPath()) != null) {
//            return;
//        }
//        if (!resource.getParent().exists()) {
//            createResourceHierarchy(resource.getParent(), monitor);
//        }
//        switch (resource.getType()) {
//        case IResource.FILE:
//            ((IFile) resource).create(new ByteArrayInputStream(new byte[0]), true, monitor);
//            break;
//        case IResource.FOLDER:
//            ((IFolder) resource).create(IResource.NONE, true, monitor);
//            break;
//        case IResource.PROJECT:
//            ((IProject) resource).create(monitor);
//            ((IProject) resource).open(monitor);
//            break;
//        }
//    }
//
//    /**
//     * Gets the output folder used for the RepreZen generation process. It fetches a value defined in the corresponding
//     * Java system property for generation folder override or uses the default.
//     * 
//     * @return Generation folder as a String
//     */
//    public static String getOutputGenerationFolder() {
//        String outputFolder = System.getProperty(OverrideGenerationDirectory.getName(), Defaults.GEN_OUTPUT_FOLDER);
//        return outputFolder;
//    }
//
//    // TODO 1757 investigate all uses
    public static boolean isZenFile(IResource resource) {
        return resource instanceof IFile && RapidFileExtensions.includes(resource.getFileExtension());
    }
//
//    public static IFile findFirstLoadableFile(IProject project, LoadabilityTester loadabilityTester) {
//        if (!project.isAccessible() || !project.isOpen()) {
//            return null;
//        }
//        LinkedList<IContainer> queue = new LinkedList<IContainer>();
//        queue.add(project.getFolder(MODELS_FOLDER_NAME));
//        while (!queue.isEmpty()) {
//            IContainer next = queue.removeFirst();
//            if (!next.exists()) {
//                continue;
//            }
//            IResource[] members;
//            try {
//                members = next.members();
//            } catch (CoreException e) {
//                members = new IResource[0];
//            }
//            for (IResource child : members) {
//                if (child instanceof IFile) {
//                    File osFile = ((IFile) child).getLocation().toFile();
//                    if (loadabilityTester.canLoad(osFile)) {
//                        return (IFile) child;
//                    }
//                } else if (child instanceof IContainer) {
//                    queue.add((IContainer) child);
//                }
//            }
//        }
//        return null;
//    }
//
//    // TODO 1757 investigate all uses
    public static boolean isZenExtension(String extension) {
        return RapidFileExtensions.includes(extension);
    }
//
//    // TODO 1757 investigate all uses
//    public static boolean isSwaggerExtension(String extension) {
//        return "json".equalsIgnoreCase(extension) || "yaml".equalsIgnoreCase(extension);
//    }
//
//    public static boolean isFile(URL url) throws RepreZenException {
//        File file = convertToFile(url);
//        return file != null ? file.isFile() : false;
//    }
//
//    public static boolean isFolder(URL url) throws RepreZenException {
//        File file = convertToFile(url);
//        return file != null ? file.isDirectory() : false;
//    }
//
//    public static InputStream readPluginResource(String uri) {
//        Assert.isTrue(!Strings.isNullOrEmpty(uri));
//        URL url;
//        try {
//            url = new URL(uri);
//            InputStream inputStream = url.openConnection().getInputStream();
//            return inputStream;
//        } catch (IOException e) {
//            String msg = String.format("Could not read plugin resource: %s", uri); //$NON-NLS-1$
//            throw new RuntimeException(msg, e);
//        }
//    }
//
//    /**
//     * Streams a file resource located in a bundle, given its name.
//     * 
//     * @param sourceBundleName
//     *            The bundle name where the resource is located.
//     * @param sourceResourceName
//     *            The resource name to copy.
//     * @param targetProject
//     *            The target project where the resource will be copied.
//     * @return InputStream of the file resource
//     * @throws RepreZenException
//     */
//    public static InputStream openFileResource(String sourceBundleName, String sourceResourceName)
//            throws RuntimeException {
//        InputStream inputStream = null;
//        Bundle sourceBundle = Platform.getBundle(sourceBundleName);
//        URL resourceUrl = sourceBundle.getResource(sourceResourceName);
//        try {
//            inputStream = resourceUrl.openStream();
//        } catch (IOException e) {
//            String msg = format("Could not open the '%s' resource.", sourceResourceName); //$NON-NLS-1$
//            throw new RuntimeException(msg, e);
//        }
//        return inputStream;
//    }
//
//    /**
//     * Refreshes the generation folder per the current user configuration.
//     * 
//     * @param project
//     *            The project containing the configured generation folder.
//     * @param monitor
//     *            The progress monitor object.
//     * @throws CoreException
//     */
//    public static void refreshGenerationFolder(IProject project, IProgressMonitor monitor) throws CoreException {
//        String generationFolder = getOutputGenerationFolder().trim();
//        if (".".equals(generationFolder)) { //$NON-NLS-1$
//            project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
//        } else {
//            IFolder folder = project.getFolder(generationFolder);
//            folder.refreshLocal(IResource.DEPTH_INFINITE, monitor);
//        }
//    }
//
//    /**
//     * Refreshes the generation folder per the current user configuration. This version of the method should be used
//     * when the handling of the thrown {@link org.eclipse.core.runtime.CoreException} is non-important and
//     * non-consequent for the following operations after this method's invocation. The exception will be swallowed
//     * albeit reported as a warning through the given plugin's logger.
//     * 
//     * @param project
//     *            The project containing the configured generation folder.
//     * @param monitor
//     *            The progress monitor object.
//     * @param plugin
//     *            The Plug-in for which the logger should be used.
//     */
//    public static void safeRefreshGenerationFolder(IProject project, IProgressMonitor monitor, Plugin plugin) {
//        String generationFolder = getOutputGenerationFolder().trim();
//        try {
//            if (".".equals(generationFolder)) { //$NON-NLS-1$
//                project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
//            } else {
//                IFolder folder = project.getFolder(generationFolder);
//                folder.refreshLocal(IResource.DEPTH_INFINITE, monitor);
//            }
//        } catch (CoreException e) {
//            ILog logger = plugin.getLog();
//            IStatus status = new Status(IStatus.WARNING, "com.modelsolv.reprezen.restapi.xtext", //$NON-NLS-1$
//                    "Could not refresh the generation folder.", e); //$NON-NLS-1$
//            logger.log(status);
//        }
//    }
//
//    public static IFile createOrUpdateFile(IProject project, IPath path, String content, IProgressMonitor monitor)
//            throws CoreException {
//        IFile file = project.getFile(path);
//        if (!file.exists()) {
//            createResourceHierarchy(file, monitor);
//        }
//        file.setContents(new ByteArrayInputStream(content.getBytes(Charsets.UTF_8)), true, false, monitor);
//        return file;
//    }
//
//    private WorkspaceUtils() {
//    }
//
//    /*
//     * Returns true if the path is not null and is a folder.
//     */
//    public static boolean isValidModelContainerPath(IPath path) {
//        if (null == path) {
//            return false;
//        }
//
//        IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
//
//        return !Defaults.GEN_OUTPUT_FOLDER.equals(resource.getName()) && !path.toFile().isHidden()
//                && resource instanceof IFolder;
//    }
//
//    /**
//     * @param model
//     *            model file.
//     * @return relative path from project root to generation output folder for given model.
//     */
//    public static String getOutputGenerationFolderForModel(IFile model) {
//        IPath modelRelativePath = model.getProjectRelativePath();
//        String genTargetsFolderName = getOutputGenerationFolder();
//        IPath genFolderPath = model.getProject().getProjectRelativePath(); // empty project-relative path
//        genFolderPath = genFolderPath.append(genTargetsFolderName); // project/gentargets
//        if (modelRelativePath.segmentCount() > 1) {
//            String firstSeg = modelRelativePath.segment(0);
//            if (!(firstSeg.equals(MODELS_FOLDER_NAME) || firstSeg.equals(genTargetsFolderName))) {
//                // model not in standard location nor in generated output - mimic model path under gentargets folder
//                genFolderPath = genFolderPath.append(modelRelativePath.removeLastSegments(1));
//            }
//        }
//        // append model name
//        String modelName = modelRelativePath.lastSegment();
//        if (modelName != null && modelName.contains(".")) {
//            modelName = modelName.substring(0, modelName.lastIndexOf('.'));
//        } else if (modelName == null) {
//            modelName = "UnknownModel"; // shouldn't ever happen
//        }
//        return genFolderPath.append(modelName).toString();
//    }
//
//    /**
//     * @return <code>true</code> if workspace contains at least one ZEN file
//     */
//    // TODO 1757 See if this matters
//    public static boolean workspaceContainsZenFile() {
//        final AtomicBoolean result = new AtomicBoolean(false);
//        try {
//            ResourcesPlugin.getWorkspace().getRoot().accept(new IResourceProxyVisitor() {
//                @Override
//                public boolean visit(IResourceProxy proxy) throws CoreException {
//                    if (proxy.getType() == IResource.FILE && WorkspaceUtils.isZenFile(proxy.requestResource())) {
//                        result.set(true);
//                        return false;
//                    }
//                    return true;
//                }
//            }, IResource.DEPTH_INFINITE);
//        } catch (CoreException e) {
//            // ignore exception
//        }
//        return result.get();
//    }
//
//    public static Optional<IFile> getFile(String path) {
//        IFile file = null;
//        if (Strings.emptyToNull(path) != null) {
//            try {
//                file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
//            } catch (Exception e) {
//                // ignore
//            }
//        }
//        return Optional.ofNullable(file);
//    }
//
//    public static Optional<IFolder> getFolder(IPath path) {
//        IFolder folder;
//        try {
//            folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
//        } catch (Exception e) {
//            folder = null;
//        }
//        return Optional.ofNullable(folder);
//    }
}
