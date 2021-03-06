package com.jayway.maven.plugins.android.generation2.samples.libraryprojects.mainapp;

import android.test.ActivityInstrumentationTestCase2;
import com.jayway.android.robotium.solo.Solo;

/**
 * Tests that {@link MainActivity} displays correct data from its libraries.
 *
 * @author hugo.josefson@jayway.com
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo robotium;

    public MainActivityTest() {
        super("com.jayway.maven.plugins.android.generation2.samples.libraryprojects.mainapp", MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        robotium = new Solo(getInstrumentation(), getActivity());
    }

    public void testFrameworkLaunchesAtAll() {
    }

    public void testMainActivityAppears() {
        assertTrue(robotium.waitForActivity("MainActivity", 20000));
    }

    public void testMainActivityTextAppears() {
        assertTrue(robotium.searchText("Hello World, MainActivity"));
    }

    public void testLib1ResourceAppears() {
        assertTrue(robotium.searchText("This is from a resource in libraryprojects-lib1."));
    }

    public void testLib2ResourceAppears() {
        assertTrue(robotium.searchText("This is from a resource in libraryprojects-lib2."));
    }

    public void testLib1AssetAppears() {
        assertTrue(robotium.searchText("This is from an asset in libraryprojects-lib1."));
    }

    public void testLib2AssetAppears() {
        assertTrue(robotium.searchText("This is from an asset in libraryprojects-lib2."));
    }

    public void testLib1ClassAppears() {
        assertTrue(robotium.searchText("This is from a class in libraryprojects-lib1."));
    }

    public void testLib2ClassAppears() {
        assertTrue(robotium.searchText("This is from a class in libraryprojects-lib2."));
    }

    public void testLib1JavaResourceAppears() {
        assertTrue(robotium.searchText("This is from a java resource in libraryprojects-lib1."));
    }

    public void testLib2JavaResourceAppears() {
        assertTrue(robotium.searchText("This is from a java resource in libraryprojects-lib2."));
    }


    /**
     * Finalizes the Robotium Solo instance, as recommended by Robotium's Getting Started guide.
     *
     * @throws Exception if {@code super.tearDown()} does.
     */
    @Override
    public void tearDown() throws Exception {
        try {
            robotium.finalize();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        getActivity().finish();
        super.tearDown();
    }

}
