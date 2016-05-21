package BspTiefensuche;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Tiefensuche extends BaseTree<Film> {

	@Override
	/**
	 * Sortierkriterium im Baum: L�nge des Films
	 */
	protected int compare(Film a, Film b) {

		return a.compareTo(b);
	}

	/**
	 * Retourniert die Titelliste der Film-Knoten des Teilbaums in symmetrischer Folge (engl. in-order, d.h. links-Knoten-rechts)
	 * @param node Wurzelknoten des Teilbaums
	 * @return Liste der Titel in symmetrischer Reihenfolge
	 */
	public List<String> getNodesInOrder(Node<Film> node) {

		List<String> flatList = new ArrayList<String>();
		
		if (node.getLeft() != null)
		{
			flatList.addAll(getNodesInOrder(node.getLeft()));
		}
		
		flatList.add(node.getValue().getTitel());
		
		if (node.getRight() != null)
		{
			flatList.addAll(getNodesInOrder(node.getRight()));
		}
		
		return flatList;
	}
		
	/**
	 * Retourniert Titelliste jener Filme, deren L�nge zwischen min und max liegt, in Hauptreihenfolge (engl. pre-order, d.h. Knoten-links-rechts)
	 * @param min Minimale L�nge des Spielfilms
	 * @param max Maximale L�nge des Spielfilms
	 * @return Liste der Filmtitel in Hauptreihenfolge
	 */
	public List<String> getMinMaxPreOrder(double min, double max) {

		return getMinMaxPreOrder(getRoot(), min, max);
	}
	
	private List<String> getMinMaxPreOrder(Node<Film> node, double min, double max){
		
		List<String> flatList = new ArrayList<String>();
		
		// Beim eigenen �berpr�fen
		if (node.getValue().getL�nge() >= min && node.getValue().getL�nge() <= max)
		{
			flatList.add(node.getValue().getTitel());
		}
		// Links �berpr�fen (Eigene Filml�nge gr��er/gleich MIN ?)
		if (node.getLeft() != null && node.getValue().getL�nge() >= min)
		{
			flatList.addAll(getMinMaxPreOrder(node.getLeft(), min, max));
		}
		// Rechts �berpr�fen (Eigene Filml�nge kleiner-gleich MAX ?)
		if (node.getRight() != null && node.getValue().getL�nge() <= max)
		{
			flatList.addAll(getMinMaxPreOrder(node.getRight(), min, max));
		}
		
		return flatList;
	}

}
