(ns gigasecond
  (:import java.util.Calendar))

(defn from [year month day]
  (let [c (doto
            (Calendar/getInstance)
            (.set year (dec month) day)
            (.add Calendar/SECOND 1000000000))]
    [(.get c Calendar/YEAR)
     (inc (.get c Calendar/MONTH))
     (.get c Calendar/DATE)]))
