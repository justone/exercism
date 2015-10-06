(ns point-mutations)

(defn hamming-distance
  [a b]
  (when (= (count a) (count b))
    (->> (map not= a b)
         (filter true?)
         count)))
