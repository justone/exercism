(ns grade-school)

(defn add
  [db name grade]
  (update-in db [grade] concat [name]))

(defn grade
  [db grade]
  (db grade []))

(defn sorted
  [db]
  (into (sorted-map) (map #(vector (first %) (sort (second %))) db)))
