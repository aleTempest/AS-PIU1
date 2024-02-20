package upvictoria.pm_ene_abr_2024.iti_271164.pg1u1_eq02;

abstract class ClassProperty {
    private final EncType encType;
    private final String name;
    private final String attributeType;
    private final boolean isAbstract;

    public ClassProperty(EncType encType, String name, String attributeType, boolean isAbstract) {
        if (name == null || name.isEmpty()) {
            throw new InvalidClassAttributeException("Attribute name is empty");
        }
        if (attributeType == null || attributeType.isEmpty()) {
            throw new InvalidClassAttributeException("Attribute type is empty");
        }

        this.encType = encType;
        this.name = name;
        this.attributeType = attributeType;
        this.isAbstract = isAbstract;
    }

    private String getEncType() {
        switch (encType) {
            case PRIVATE:   return "-";
            case PUBLIC:    return "+";
            case PROTECTED: return "#";
            default:        return "";
        }
    }

    @Override
    public String toString() {
        String str = getEncType();
        if (isAbstract) {
            str += "abstract "; // Use of space here
        }
        str += name; // Removed extra space
        return str;
    }

    class ClassAttribute extends ClassProperty {
        public ClassAttribute(EncType encType, String name, String attributeType, boolean isAbstract) {
            super(encType, name, attributeType, isAbstract);
        }

        @Override
        public String toString() {
            return super.toString() + " : " + attributeType; // Corrected colon placement
        }
    }

    class ClassMethod extends ClassProperty {
        public ClassMethod(EncType encType, String name, String attributeType, boolean isAbstract) {
            super(encType, name, attributeType, isAbstract);
        }

        @Override
        public String toString() {
            return super.toString() + "() : " + attributeType;
        }
    }
}