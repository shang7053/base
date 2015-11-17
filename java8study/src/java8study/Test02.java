package java8study;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 实现事件处理
 * 
 * @author Administrator
 *
 */
public class Test02 {
	/*
	 * 如果你曾经做过Swing 编程，你将永远不会忘记编写事件侦听器代码。使用lambda表达式如下所示写出更好的事件侦听器的代码。
	 * 
	 * // Before Java 8: JButton show = new JButton("Show");
	 * show.addActionListener(new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * System.out.println("without lambda expression is boring"); } });
	 * 
	 * 
	 * // Java 8 way: show.addActionListener((e) -> {
	 * System.out.println("Action !! Lambda expressions Rocks"); }); 在java
	 * 8中你可以使用Lambda表达式替代丑陋的匿名类。
	 */
	public static void main(String[] args) {
		JButton show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("without lambda expression is boring");
			}
		});
		show.addActionListener((e)->{System.out.println(e.getClass());});
	}
}
