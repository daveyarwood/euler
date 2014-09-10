(ns euler.001)

(defn divides? [x y]
	(zero? (rem x y)))

(defn divides-any [& nums]
	(fn [arg]
		(boolean (some #(divides? arg %) nums))))

(->> (range 1000) 
	(filter (divides-any 3 5))
	(apply +))
