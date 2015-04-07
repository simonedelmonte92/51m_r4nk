package sketch;

import java.util.LinkedHashMap;

public class KMinHashingSketchSetContainmentHandler {
	
	public double getMultipleContainmentSimilarity(
			KMinHashingSketchSetContainment[] sketches) {
		// MUST TO BE CHANGED!!!
		int num_common_elements = 0;
		int i = 0;
		Long element = null;
		int sum_of_lengths = 0;
		for (KMinHashingSketchSetContainment sk : sketches) {
			sum_of_lengths += sk.getLength();
		}
		LinkedHashMap<Long, Integer> element_num_sets = new LinkedHashMap<Long, Integer>(
				sum_of_lengths);
		for (KMinHashingSketchSetContainment sk : sketches) {
			for (i = 0; i < sk.sketch.length; i++) {
				element = sk.sketch[i];
				element_num_sets.put(element,
						(element_num_sets.get(element) == null ? 0
								: element_num_sets.get(element)) + 1);
				if (element_num_sets.get(element) == sketches.length) {
					num_common_elements++;
				}
			}
		}
		return (double) num_common_elements / (double) sketches[0].getLength();
	}
	
	public  KMinHashingSketchSetContainment mergeSketches(
			MinHashingSketch[] sketches) {
		// This is interesting for "OR" queries...
		return null;
	}
}