import java.util.*;

public class ConceptGraph {
    public static void main(String[] args) {
        GraphNode gre = constructGraph();

        gre.prettyDisplay(gre, 0);
    }

    public static GraphNode constructGraph() {
        // Root of the GRE concept tree
        GraphNode gre = new GraphNode("GRE", 0, 0, 0, 0);

        // Insert nodes into the graph based on the paths provided
        gre.insert("001Z", "GRE", 1.0f, 1, 3, 0);
        gre.insert("001Z0001", "Verbal", 0.5f, 2, 3, 0);
        gre.insert("001Z0002", "Quant", 0.5f, 2, 4, 0);
        gre.insert("001Z0003", "Analytical Writing", 1.0f, 2, 2, 0);

        gre.insert("001Z00010001", "Reading Comprehension", 0.5f, 3, 0, 10);
        gre.insert("001Z00010006", "Critical Reasoning", 0.05f, 3, 0, 1);
        gre.insert("001Z00010007", "Discrete Questions", 0.45f, 3, 4, 0);

        gre.insert("001Z00020001", "Arithmetic", 0.25f, 3, 9, 5);
        gre.insert("001Z00020002", "Algebra", 0.25f, 3, 8, 5);
        gre.insert("001Z00020003", "Geometry", 0.25f, 3, 6, 5);
        gre.insert("001Z00020004", "Data Analysis", 0.25f, 3, 9, 5);

        gre.insert("001Z00030001", "Analyze an Issue", 1.0f, 3, 0, 0);
        gre.insert("001Z00030002", "Analyze an Argument", 0.0f, 3, 0, 1);

        gre.insert("001Z000100070001", "Text Completion - 1 Blank", 0.22f, 4, 0, 2);
        gre.insert("001Z000100070002", "Text Completion - 2 Blank", 0.22f, 4, 0, 2);
        gre.insert("001Z000100070003", "Text Completion - 3 Blank", 0.22f, 4, 0, 2);
        gre.insert("001Z000100070004", "Sentence Equivalence", 0.34f, 4, 0, 3);

        gre.insert("001Z000200010001", "Sets of Numbers", 1.0f, 4, 0, 0);
        gre.insert("001Z000200010002", "Arithmetic Operations", 1.0f, 4, 0, 0);
        gre.insert("001Z000200010003", "Properties of Integers", 1.0f, 4, 0, 0);
        gre.insert("001Z000200010004", "Exponents & Roots", 1.0f, 4, 0, 0);
        gre.insert("001Z000200010005", "Fractions & Decimals", 1.0f, 4, 0, 0);
        gre.insert("001Z000200010006", "Ratio & Proportion", 1.0f, 4, 0, 0);
        gre.insert("001Z000200010007", "Percentages", 1.0f, 4, 0, 0);
        gre.insert("001Z000200010008", "Rates", 1.0f, 4, 0, 0);
        gre.insert("001Z000200010009", "Absolute Numbers & Number Line", 1.0f, 4, 0, 0);

        gre.insert("001Z000200020001", "Algebraic Identities", 1.0f, 4, 0, 0);
        gre.insert("001Z000200020002", "Simplifying Algebraic Expressions", 1.0f, 4, 0, 0);
        gre.insert("001Z000200020003", "Linear Equations in 1 Variable", 1.0f, 4, 0, 0);
        gre.insert("001Z000200020004", "Linear Inequalities", 1.0f, 4, 0, 0);
        gre.insert("001Z000200020005", "Linear Equations in 2 Variables", 1.0f, 4, 0, 0);
        gre.insert("001Z000200020006", "Quadratic Equations", 1.0f, 4, 0, 0);
        gre.insert("001Z000200020007", "Word Problems in Algebra", 1.0f, 4, 0, 0);

        gre.insert("001Z000200030001", "Lines and Angles", 1.0f, 4, 0, 0);
        gre.insert("001Z000200030002", "Triangles", 1.0f, 4, 0, 0);
        gre.insert("001Z000200030003", "Similarity and Congruence of Triangles", 1.0f, 4, 0, 0);
        gre.insert("001Z000200030004", "Quadrilaterals", 1.0f, 4, 0, 0);
        gre.insert("001Z000200030005", "Circles", 1.0f, 4, 0, 0);
        gre.insert("001Z000200030006", "3D Geometry", 1.0f, 4, 0, 0);

        gre.insert("001Z000200040001", "Sets and Lists", 1.0f, 4, 0, 0);
        gre.insert("001Z000200040002", "Sequences and Series", 1.0f, 4, 0, 0);
        gre.insert("001Z000200040003", "Factorials & Counting Principle", 1.0f, 4, 0, 0);
        gre.insert("001Z000200040004", "Permutations & Combinations", 1.0f, 4, 0, 0);
        gre.insert("001Z000200040005", "Probability", 1.0f, 4, 0, 0);
        gre.insert("001Z000200040006", "Measures of Central Tendency", 1.0f, 4, 0, 0);
        gre.insert("001Z000200040007", "Measures of Dispersion", 1.0f, 4, 0, 0);
        gre.insert("001Z000200040008", "Normal Distribution", 1.0f, 4, 0, 0);
        gre.insert("001Z000200040009", "Data Interpretation", 1.0f, 4, 0, 0);

        return gre;
    }
}