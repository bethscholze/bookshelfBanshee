package com.googlebooksapi.entity;

/**
 * The type Panelization summary.
 */
public class PanelizationSummary{
	private boolean containsImageBubbles;
	private boolean containsEpubBubbles;

    /**
     * Set contains image bubbles.
     *
     * @param containsImageBubbles the contains image bubbles
     */
    public void setContainsImageBubbles(boolean containsImageBubbles){
		this.containsImageBubbles = containsImageBubbles;
	}

    /**
     * Is contains image bubbles boolean.
     *
     * @return the boolean
     */
    public boolean isContainsImageBubbles(){
		return containsImageBubbles;
	}

    /**
     * Set contains epub bubbles.
     *
     * @param containsEpubBubbles the contains epub bubbles
     */
    public void setContainsEpubBubbles(boolean containsEpubBubbles){
		this.containsEpubBubbles = containsEpubBubbles;
	}

    /**
     * Is contains epub bubbles boolean.
     *
     * @return the boolean
     */
    public boolean isContainsEpubBubbles(){
		return containsEpubBubbles;
	}

	@Override
 	public String toString(){
		return 
			"PanelizationSummary{" + 
			"containsImageBubbles = '" + containsImageBubbles + '\'' + 
			",containsEpubBubbles = '" + containsEpubBubbles + '\'' + 
			"}";
		}
}
