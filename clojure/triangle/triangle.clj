(ns triangle
  (:refer-clojure :exclude [type]))

(defn type [& sides]
  (let [[a b longest] (sort sides)]
    (if (>= longest (+ a b))
      :illogical
      (condp = (count (set sides))
        1 :equilateral
        2 :isosceles
        3 :scalene))))
