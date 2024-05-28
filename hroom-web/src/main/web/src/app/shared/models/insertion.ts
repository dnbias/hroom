import{Tag} from "./tags";

export interface insertion {
  insertion_type: string;
  id: number;
  landlordId: number;
  name: string;
  features: Tag[];
  description: string[];
  price: number;
  city: string;
  address: string;
  area: number;
  photoIds: number[];
  rating: number;
  receivedFeedbacksIds: number[];
  availabilityId: number;
}
