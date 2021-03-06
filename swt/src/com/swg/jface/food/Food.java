/*
 * Created on Jun 9, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.swg.jface.food;

/**
 * This class represents a type of food
 */
public class Food {
  // The name of the food
  private String name;

  // Is it healthy?
  private boolean healthy;

  /**
   * Food constructor
   * 
   * @param name the name
   * @param healthy whether or not it's healthy
   */
  public Food(String name, boolean healthy) {
    this.name = name;
    this.healthy = healthy;
  }

  /**
   * Gets whether this is healthy
   * 
   * @return boolean
   */
  public boolean isHealthy() {
    return healthy;
  }

  /**
   * Gets the name
   * 
   * @return String
   */
  public String getName() {
    return name;
  }
}