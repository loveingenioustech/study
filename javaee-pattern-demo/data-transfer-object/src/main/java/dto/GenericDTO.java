package dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import type.Attribute;
import type.IntType;
import type.StringType;
import exception.CompositeValidationException;
import exception.ValidationException;

public class GenericDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Map<String, Attribute> attributes = null;

	private Map<String, Set<GenericDTO>> relations = null;

	private String name = null;

	public GenericDTO(String name) {
		notNull(name, "The name of the DTO cannot be null...");
		this.attributes = new HashMap<String, Attribute>();
		this.relations = new HashMap<String, Set<GenericDTO>>();
		this.name = name;
	}

	public GenericDTO add(String name, Attribute attribute) {
		notNull(name, "Attribute name cannot be null");
		notNull(attribute, "Attribute with name: " + name + " is null!");
		this.attributes.put(name, attribute);
		return this;
	}

	public GenericDTO addString(String name, String value) {
		notNull(name, "Attribute name cannot be null");
		notNull(value, "Attribute with name: " + name + " is null!");
		this.attributes.put(name, new StringType(null, value));
		return this;
	}

	public GenericDTO remove(String name) {
		notNull(name, "Attribute name cannot be null");
		this.attributes.remove(name);
		return this;
	}

	public GenericDTO addRelation(String relationName, GenericDTO genericDTO) {
		notNull(relationName, "The name of the relation cannot be null !");
		notNull(genericDTO, "The target cannot for the relation with name "
				+ relationName + " be null");
		addTarget(relationName, genericDTO);
		return this;
	}

	private GenericDTO addTarget(String relationName, GenericDTO target) {
		Set<GenericDTO> targets = this.relations.get(relationName);
		if (targets == null) {
			targets = new HashSet<GenericDTO>();
			this.relations.put(relationName, targets);
		}
		targets.add(target);
		return this;
	}

	public Attribute get(String name) {
		notNull(name, "Attribute name cannot be null");
		return this.attributes.get(name);
	}

	public Set<GenericDTO> getTargets(String name) {
		notNull(name, "The name of the relation cannot be null !");
		return this.relations.get(name);
	}

	public GenericDTO getTarget(String name) {
		notNull(name, "The name of the relation cannot be null !");
		return this.relations.get(name).iterator().next();
	}

	public Iterator<String> getAttributeNames() {
		return this.attributes.keySet().iterator();
	}

	public Iterator<String> getRelationNames() {
		return this.relations.keySet().iterator();
	}

	public Iterator<Attribute> getAttributes() {
		return this.attributes.values().iterator();
	}

	public Iterator<Set<GenericDTO>> getTargets() {
		return this.relations.values().iterator();
	}

	public GenericDTO validate() throws CompositeValidationException {
		Set<Map.Entry<String, Attribute>> attibuteEntries = this.attributes
				.entrySet();
		Iterator<Map.Entry<String, Attribute>> attributeIterator = attibuteEntries
				.iterator();
		CompositeValidationException compositeValidationException = new CompositeValidationException(
				this.name);
		Map.Entry<String, Attribute> entry = null;
		while (attributeIterator.hasNext()) {
			try {
				entry = attributeIterator.next();
				Attribute attributeEntry = entry.getValue();
				attributeEntry.validate();
			} catch (ValidationException ex) {
				compositeValidationException.add(entry.getKey(), ex);
			}
			// some validation errors occured
			if (!compositeValidationException.isEmpty()) {
				throw compositeValidationException;
			}
		}
		return this;
	}

	public int getNumberOfAttributes() {
		return this.attributes.size();
	}

	public boolean isEmpty() {
		return (this.attributes.isEmpty() && this.relations.isEmpty());
	}

	private void notNull(String name, String value) {
		// if (name == null)
		// throw new Exception("cannot be null !");

	}

	private void notNull(Attribute attribute, String value) {
		// TODO Auto-generated method stub
	}

	private void notNull(GenericDTO genericDTO, String value) {
		// TODO Auto-generated method stub
	}

	public GenericDTO addInt(String name, int value) {
		return this.addString(name, String.valueOf(value));
	}
}
