(ns nucleotide-count)

(defn nucleotide-counts
  [input]
  (merge (zipmap "ATCG" (repeat 0)) (frequencies input)))

(defn count
  [char input]
  (or (get (nucleotide-counts input) char) (throw (Exception. "invalid nucleotide"))))
