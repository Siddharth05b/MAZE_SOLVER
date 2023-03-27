/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JFrame;

/**
 *
 * @author 91748
 */
public class Maze_Solver extends JFrame{
    
    private int[][] maze = 
                    {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                     {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
                     {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
                     {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                     {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                     {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                     {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
                     {1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
                     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };
    
    public List<Integer> path = new ArrayList<>();
    
    public Maze_Solver(){
        setTitle("MAZE SOLVER");
        setLocation(300, 70);
        setSize(787, 630);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchpath(maze, 1, 1, path);
        //System.out.print(path);
    }
    
    @Override
    public void paint(Graphics g){
        
        g.translate(100, 90);
        
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                
                Color color;
                switch(maze[i][j]){
                    case 1:  color = Color.BLACK ;
                      break;
                      
                    case 9:  color = Color.RED;
                    break;
                    
                    default: color = Color.WHITE;
                    break;
                }
                
                g.setColor(color);
                g.fillRect(45*j, 45*i, 45, 45);
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(45*j, 45*i, 45, 45);
                
               }
            }
        for(int i=0; i<path.size(); i+=2){
            int pathx = path.get(i);
            int pathy = path.get(i+1);
            
//            System.out.println("X coordinates" + pathx);
//            System.out.println("Y coordinates" + pathy);
            
            g.setColor(Color.GREEN);
            g.fillRect(45*pathx, 45*pathy, 35, 35);
        }
        }
      public static void main(String[] args){
          Maze_Solver view = new Maze_Solver();
          view.setVisible(true);
    }
}
