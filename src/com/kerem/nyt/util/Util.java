package com.kerem.nyt.util;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

public final class Util 
{
	private Util() {}
	
	public static <E> void listeGoster(List<E> liste)
	{
		if(liste != null)
		{
			for (E e : liste) 
			{
				System.out.println(e);
			}
		}
		else
		{
			uyariMesajiYaz( "Liste g�sterilemiyor." );
		}
	}
	
	public static String processSQLException(SQLException e)
	{
		return "Error message: " + e.getMessage()
				+ "\nError code: " + e.getErrorCode()
				+ "\nSQL state: " + e.getSQLState();
	}
	
	public static void bilgiMesajiYaz(String mesaj)
	{
		JOptionPane.showMessageDialog(null, mesaj, "Bilgi Mesaj�", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void hataMesajiYaz(String mesaj)
	{
		JOptionPane.showMessageDialog(null, mesaj, "Hata Mesaj�", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void uyariMesajiYaz(String mesaj)
	{
		JOptionPane.showMessageDialog(null, mesaj, "Uyar� Mesaj�", JOptionPane.WARNING_MESSAGE);
	}
	
}
