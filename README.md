# IVGUI - Immediate Vector GUI

![IVGUI Banner](https://github.com/SPORIMEstudio/IVGUI/blob/main/banner/ivgui_banner.jpg?raw=true)

IVGUI is an uncompleted, lightweight immediate-mode vector-based graphical user interface (GUI) library built using **Java** and **OpenGLES**. 

This repository provides the core foundation and base architecture for the GUI system. While the framework is functional at its base level, it is currently an ongoing project and serves as a starting point for developers to extend and build custom UI components.

## Features
* **Immediate Mode:** UI state is handled frame-by-frame for ease of integration.
* **Vector Rendering:** Leverages OpenGLES for crisp, scalable graphics.
* **Java-Based:** Designed for cross-platform Java environments with GLES support.
* **Extensible:** Contains the base classes necessary to implement custom buttons, sliders, and panels.

## Current Project Status
> [!IMPORTANT]  
> **This project is uncompleted.** The repository contains the foundational logic for rendering and event handling, but many high-level widgets and optimizations are still in development.

## Getting Started
### Prerequisites
* Java Development Kit (JDK) 8 or higher.
* A system or framework supporting OpenGLES (such as Android or a desktop wrapper like LWJGL).

### Usage
Since this is a base framework, you can initialize the GUI context within your main render loop:

```java
// Example initialization (Pseudocode)
IVGUIContext context = new IVGUIContext();

public void onDrawFrame() {
    context.beginFrame();
    
    // UI definitions go here
    // IVGUI.button("Click Me");
    
    context.endFrame();
}
